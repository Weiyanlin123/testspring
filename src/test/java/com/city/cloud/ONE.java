package com.city.cloud;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

/**
 * @author weiyl
 * @date 2020/10/13 19:35
 */
public class ONE {
    Integer add(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        // 被加密的数据
        byte[] dataByte = Base64.decode("jMc9pzJjwx9bw8vhadZGuTQHgZKiFdnruymJKo12fN+YQ9wQqEQj6MuHjyAW60SBWKPsTbZ5BzEdnNJAOMQT5WDBemKjkzplFibIoipGknjc67I2IWbh1uhqcPnt3+MK0yVH8Aznm2+cRq9PW020ZU93dqzLeQp0JiDTABvWH75y3Z6xU/R3CpWLrCw9zxJLvTyGdkqfv0bcTPMfw9Hiiw==");
        // 加密秘钥
        byte[] keyByte = Base64.decode("4vdW0f3zZXSvSsRGNmumjw==");
        // 偏移量
        byte[] ivByte = Base64.decode("bDQch+QN7lVJc3ek6oXV9w==");
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);

            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                System.out.println("================="+JSON.parseObject(result));
            }
        } catch (Exception e) {
        }

    }
}
