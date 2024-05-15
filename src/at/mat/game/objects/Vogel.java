package at.mat.game.objects;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
public abstract class Vogel {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    public Shape shape;
    private Animation animation;

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Vogel(int x, int y, Image image, String spriteanimation,String aniname) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        animation = new Animation();
        PackedSpriteSheet pss = null;
        try {
            pss = new PackedSpriteSheet(spriteanimation);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
        for (int i=1;i<=11;i++){
            animation.addFrame(pss.getSprite(aniname+"_"+i+".png"),100);
        }

    }
    public abstract void draw(Graphics g);
    public abstract Shape getShape();
    public abstract void update(int delta);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
