package com.example.customview.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * @author zhouchao
 * @date 2019/11/13
 */
public class BitmapUtils {
    //64加密后的二进制图片
    private String imgString2 = "iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAIAAAD/gAIDAAAD6klEQVR42u2arY9VMRDF39+BwWLQCDQCjcCT4CE4BAnBQlAospaEIJAsEgMJFnAowCLWYB8nadI0nTPTue19QXBuKjbv9vbjN9Mz03YPly7fV0mWgxAIlmAJlmAJlmAJgWAJlmAJlmAJlhAIlmAJlmAJlmAJgWAJlmAJlmAJlhAIlmAJlmAJlmAJgWAJlmAJ1mnLtetPbt1+Ucq/h3Xj5tOPn74Py8uzDxh33MG791/sh/cevCpvX7/5bN+idzokdPf126+jeS4u/qCXR4/fxoNBp3QWq7CuXH347Pk5GjqOHgwUlb3WYXn6VZkVPqRvqeWOiQfIvJEAtPfV0N7ZZYj5wCAYRDBEjMP7HI5j61djUpSdqdH7Mf3AubxlG3x15+7ZzpqF/ujM7fRa0LR+XYNw3hj9JlJ4PAkL3AoPhnESgae8sBJpZdjZVv7x83crZwFKmActb4Ll2SxuJy9b22BBPvLLnopxa0Y6h9qU58j4Cq/QDgr+qL3gD0/X5yjvkDrQGdpl72Gt0YDqSOuktCPQsfGkCKsnWNRm3UPj7w6wqMHtsqfV8GOtAL7BihiyThYvHHtrf2dY1Ku7mO3JRCvAVHQrdG+SnvvkTQtHs2MLAvoSLLp8Wtn2gHaaQlOnStPzrDKxpH/RcFxS0zmNn9nuAE28QKhMdK4+XGVBCMOrjIvR1KTk23MaPwOL6lHsFF2iT+t07kmn1NWP80lr1CIXVC4z28wZWHSVVVNTlJ0o0BSslf98IKPx0RtkgUuVJOOqh7lNvzdVT9q7RIwCtcNFaxleNMOywhTnJdZUux3RWA8vI87ESs9lvIUwXI/WcwNzepsHL6fdARYN/B4Fqyxb0+hgZ0qDA63cZp5zGj8Ji2okdatOtpOHDR6y4KymRlsqBd0w6BiGGj8Ji6YwNKWwSjQ8bJiIxW1Cu/WsIn/8MH+snJFeukGJDxumE706Vfp28exwFVZ8SBSEGDqZNlzG21ov4Bbcyc2gl7idChaVreFufnjYUOQf44an0M89jy64h3Fg6zrYB5Z3EBoH4/iwgSb39WYhWF+lhfj4OPPEW4Klq7D4HoHKEFX3Vlnn5Ln4IG0ciL3bqa0avwQrSBe9s+b4sCEphZ5VkgeTQYyKM5glWIGaeiYaKkUyyFaTVFLUJT2beVlIXH/1RnrTZVzmsCEPC1Nte6E+G+/4KN/gGnEVFvordwdt8ZImjCNTGdXwY7ms7kQdv+B3vLVhy7aMEl+g0vGcEJb+MURFsARLsARLsARLRbAES7AES7AES0WwBEuwBEuwBEtFsARLsARLsARLRbAES7AES7AES0WwBEuwBEuw/qvyFye7HFD408a4AAAAAElFTkSuQmCC";


    //    TODO 1:将字符串转换成Bitmap类型（Base64字符串转换成图片）
    public Bitmap stringToBitmap(String imgBase64){
        Bitmap bitmap=null;
        try {
            byte[]bitmapArray;
            bitmapArray= Base64.decode(imgBase64, Base64.DEFAULT);
            bitmap= BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    //    TODO 2:二进制流转换为Bitmap图片
    public Bitmap getBitmapFromByte(byte[] temp) {
        if (temp != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(temp, 0, temp.length);
            return bitmap;
        } else {
            return null;
        }
    }
    //    TODO3:Bitmap转换为二进制流
    private static byte[] bitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imgBytes = baos.toByteArray();
        return imgBytes;
    }
//    TODO 4:String路径图片转二进制
    /**
     * 照片转byte二进制
     * @param imagepath 需要转byte的照片路径
     * @return 已经转成的byte
     * @throws Exception
     */
    public static byte[] readStream(String imagepath) throws Exception {
        FileInputStream fs = new FileInputStream(imagepath);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while (-1 != (len = fs.read(buffer))) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        fs.close();
        return outStream.toByteArray();
    }
}
