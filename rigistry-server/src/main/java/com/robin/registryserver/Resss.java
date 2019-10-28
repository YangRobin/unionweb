package com.robin.registryserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Resss implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private int age;

  @Override
  public String toString() {
    return "Resss [age=" + age + ", name=" + name + "]";
  }

  public static void main(String[] args) throws Exception{
    EeSerializable();
    DeSerializable();
  }

  /**
   * 序列化
   * @throws Exception
   */
  public static void EeSerializable() throws Exception{
    // ObjectOutputStream 对象输出流，将 Resss 对象存储到E盘的 aa.txt 文件中，完成对 Resss 对象的序列化操作
    Resss res = new Resss();
    res.setAge(22);
    res.setName("davdeyang");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("f:/aa.txt")));
    oos.writeObject(res);
    oos.close();
  }

  /**
   * 反序列化
   * @return
   * @throws Exception
   */
  public static Resss DeSerializable() throws Exception{
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("f:/aa.txt")));
    Resss ress = (Resss) ois.readObject();
    System.out.println(ress.getName() + ress.getAge());
    return ress;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}