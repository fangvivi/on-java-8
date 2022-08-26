package com.wayne.design_pattern.proxy.static_proxy;

/**
 * Image的代理对象
 * @author wayne
 */
public class ImageProxy implements Image{
    private RealImage image;
    private final String name;

    public ImageProxy(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if(image == null){
            image = new RealImage(name);
        }
        image.display();
    }

    public static void main(String[] args) {
        ImageProxy proxy = new ImageProxy("清明上河图");
        proxy.display();
    }
}
