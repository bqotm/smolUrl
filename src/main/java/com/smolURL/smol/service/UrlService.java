package com.smolURL.smol.service;


import com.smolURL.smol.dto.UrlRequest;
import com.smolURL.smol.entities.UrlMapping;
import com.smolURL.smol.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UrlService {

    private UrlRepository urlRepository;

    public List<UrlMapping> getAll() {
        return urlRepository.findAll();
    }

    public UrlMapping createUrlMapping(UrlRequest urlRequest) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); //converts longUrl to a byte array(size=16)
            String originalUrl=urlRequest.getOriginalUrl();
            UrlMapping urlMapping;
            if(urlRequest.getCustomXsUrl()!=null){
                 urlMapping = new UrlMapping(urlRequest.getCustomXsUrl(), originalUrl, LocalDateTime.now(), LocalDateTime.now().plusYears(2));
            } else {
                byte[] messageDigest = md.digest(originalUrl.getBytes());  //16bytes array


                BigInteger no = new BigInteger(1, messageDigest); //converting the byte array into BigInteger

                String bin_num = no.toString(2); //converting Biginteger into a BinaryString
                long num = getLONG(bin_num); //converting First 36 bits of the BinaryString(128bit) to Long


                String hashtext = getbase62(num); //converting Long to base62 (tinyUrl)
                while (hashtext.length() < 6) {
                    hashtext = "0" + hashtext;
                }
                urlMapping = new UrlMapping(hashtext, originalUrl, LocalDateTime.now(), LocalDateTime.now().plusYears(2));
            }
            urlRepository.insert(urlMapping);
            return urlMapping;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    //conversion of Long to Base62
    public String getbase62(long num) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result = "";
        int cnt = 6;
        while (num != 0 && cnt > 0) {
            long r = num % 62;
            result += base.charAt((int) r);
            num = num / 62;
            cnt--;
        }
        return result;

    }

    //converting first 36 bits to Long
    public Long getLONG(String bin) {
        long num = 0;
        long pow = 1;
        for (int i = 35; i >= 0; i--) {
            pow = pow * 2;
            if (bin.charAt(i) == '1')
                num = num + pow;
        }
        return num;
    }
}
