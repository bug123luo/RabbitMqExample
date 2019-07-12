package com.lcclovehww.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author lcc
 * @date 2019/7/12 - 10:56
 */
public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content){
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    //修改数据内容
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    //若数据内容修改过，则保存到文件中
    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    //将数据内容实际保存到文件中
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName()+"calls doSave, content= "+content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
