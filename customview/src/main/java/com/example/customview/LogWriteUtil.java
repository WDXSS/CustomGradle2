package com.example.customview;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriteUtil {

    private static String MYLOG_PATH_SDCARD_DIR = "/log";// 日志文件在sdcard中的路径
    private static String MYLOGFILEName = "Log.txt";// 本类输出的日志文件名称
    private static SimpleDateFormat myLogSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日志的输出格式
    private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日志文件格式

    private static long lastTime = 0;

    public static void writeLogtoFile(String mylogtype, String tag, String text) {// 新建或打开日志文件
        String needWriteFiel;
        Date nowtime = new Date();
        if (lastTime + 2 * 60 * 1000 < nowtime.getTime()) {
            lastTime = nowtime.getTime();
        }
        needWriteFiel = logfile.format(lastTime);

        String needWriteMessage = myLogSdf.format(nowtime) + "    " + mylogtype + "    " + tag + "    " + text;
        File dirPath = Environment.getExternalStorageDirectory();
        String rootPath = dirPath.getPath();

        String filePath = rootPath + MYLOG_PATH_SDCARD_DIR;
        System.out.println("path = " + dirPath.getPath());
        File dirsFile = new File(filePath);
        if (!dirsFile.exists()) {
            dirsFile.mkdirs();
        }
        //Log.i("创建文件","创建文件");
        File file = new File(dirsFile.getPath(), needWriteFiel + MYLOGFILEName);// MYLOG_PATH_SDCARD_DIR
        if (!file.exists()) {
            try {
                //在指定的文件夹中创建文件
                file.createNewFile();
            } catch (Exception e) {
            }
        }

        try {
            FileWriter filerWriter = new FileWriter(file, true);// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(needWriteMessage);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
