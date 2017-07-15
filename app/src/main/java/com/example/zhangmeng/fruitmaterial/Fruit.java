package com.example.zhangmeng.fruitmaterial;

import android.widget.ImageView;

/**
 * Created by zhangmeng on 2017/7/14.
 */

public class Fruit {
    private String fruitName;
    private int fruitImage;

    public Fruit(String fruitName, int fruitImage) {
        this.fruitName = fruitName;
        this.fruitImage = fruitImage;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitImage() {
        return fruitImage;
    }

    public void setFruitImage(int fruitImage) {
        this.fruitImage = fruitImage;
    }
}
