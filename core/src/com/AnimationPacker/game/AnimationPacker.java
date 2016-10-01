package com.AnimationPacker.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimationPacker extends ApplicationAdapter {
	SpriteBatch batch;
//	Texture img;
	
	int x;
	int y;
	
	BufferedImage bi;
	
	String name;
	int f;
	int w;
	int h;
	int r;
	int c;
	String save;
	
	Scanner in = new Scanner(System.in);
	
	@Override
	public void create () {
		

		
		System.out.println("Name? :");
		name = in.nextLine();
		System.out.println("Frame count? :");
		f = in.nextInt();
		System.out.println("Width? :");
		w = in.nextInt();
		System.out.println("Height? :");
		h = in.nextInt();
		System.out.println("Row count? :");
		r = in.nextInt();
		System.out.println("Column count? :");
		c = in.nextInt();
		System.out.println("Save as :");
		save = in.nextLine();
		

				BufferedImage result = new BufferedImage(w*c, h*r, BufferedImage.TYPE_INT_RGB);
				Graphics g = result.getGraphics();
				
				for(int ct = 0; ct < f; ct++){
					if(ct<10)
					{
						try {
							bi = ImageIO.read(new File(name+String.format("000", ct)));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						try {
							bi = ImageIO.read(new File(name+String.format("00", ct)));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			        g.drawImage(bi, 0, 0, null);
			        x += w;
			        if(x > result.getWidth()){
			            x = 0;
			            y += h;
			        }
			    }

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		batch.begin();
	//	batch.draw(img, 0, 0);
		batch.end();
	}
}
