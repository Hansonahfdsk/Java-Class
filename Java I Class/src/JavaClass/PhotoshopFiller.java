package JavaClass;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PhotoshopFiller extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		Color c = pixels[i][j];
        		int R = Math.max(0, Math.min(c.getRed() + amount, 255));
        		int G = Math.max(0, Math.min(c.getGreen() + amount, 255));
        		int B = Math.max(0, Math.min(c.getBlue() + amount, 255));
        		pixels[i][j] = new Color(R, G, B);
        	}
        }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        if (horizontally) {
            for (int i = 0; i < h; i++) {
            	for (int j = 0; j < w; j++) {
            		Color c = pixels[i][j];
            		pixels[i][j] = pixels[i][w - j - 1];
            		pixels[i][w - j - 1] = c;
            	}
            }
        }
        else {
            for (int i = 0; i < h; i++) {
            	for (int j = 0; j < w; j++) {
            		Color c = pixels[i][j];
            		pixels[i][j] = pixels[h - i - 1][j];
            		pixels[h - i - 1][j] = c;
            	}
            }
        }
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		Color c = pixels[i][j];
        		int R = 255 - c.getRed();
        		int G = 255 - c.getGreen();
        		int B = 255 - c.getBlue();
        		pixels[i][j] = new Color(R, G, B);
        	}
        }
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    	double d = Math.sqrt(Math.pow((c1.getRed() - c2.getRed()), 2) + Math.pow((c1.getGreen() - c2.getGreen()), 2) + Math.pow((c1.getBlue() - c2.getBlue()), 2));
    	return d;
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		Color c = pixels[i][j];
        		int minI = 0;
        		for (int k = 1; k < colorList.length; k++) {
        			if (distance(c, colorList[k]) < distance(c, colorList[minI])) {
        				minI = k;
        			}
        		}
        		pixels[i][j] = colorList[minI];
        	}
        }
         
    }



    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
		outputName = "blurred_" + outputName;
		int R[][] = new int[h][w];
		int G[][] = new int[h][w];
		int B[][] = new int[h][w];
        for (int i = -1; i < h - 1; i++) {
        	for (int j = -1; j < w - 1; j++) {
        		int avgRed = 0, avgGreen = 0, avgBlue = 0, div = 9;
        		for (int k = i; k < i + 3; k++) {
        			for (int l = j; l < j + 3; l++) {
        				if (k >= h || l >= w || k < 0 || l < 0) {
        					div--;
        					continue;
        				}
                		Color c = pixels[k][l];
                		avgRed += c.getRed();
                		avgGreen += c.getGreen();
                		avgBlue += c.getBlue();
        			}
        		}
        		R[i + 1][j + 1] = avgRed / div;
        		G[i + 1][j + 1] = avgGreen / div;
        		B[i + 1][j + 1] = avgBlue / div;
        	}
        }
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		pixels[i][j] = new Color(R[i][j], G[i][j], B[i][j]);
        	}
        }
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
		int R[][] = new int[h][w];
		int G[][] = new int[h][w];
		int B[][] = new int[h][w];
        for (int i = -1; i < h - 1; i++) {
        	for (int j = -1; j < w - 1; j++) {
        		int Red = 0, Green = 0, Blue = 0, div = 9;
        		for (int k = i; k < i + 3; k++) {
        			for (int l = j; l < j + 3; l++) {
        				if (k >= h || l >= w || k < 0 || l < 0 || (k == i + 1 && l == j + 1)) {
        					div--;
        					continue;
        				}
                		Color c = pixels[k][l];
                		Red += c.getRed();
                		Green += c.getGreen();
                		Blue += c.getBlue();
        			}
        		}
        		Color c = pixels[i + 1][j + 1];
        		R[i + 1][j + 1] = Math.max(0, Math.min(Red * -1 + c.getRed() * 8, 255));
        		G[i + 1][j + 1] = Math.max(0, Math.min(Green * -1 + c.getGreen() * 8, 255));
        		B[i + 1][j + 1] = Math.max(0, Math.min(Blue * -1 + c.getBlue() * 8, 255));
        	}
        }
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		pixels[i][j] = new Color(R[i][j], G[i][j], B[i][j]);
        	}
        }
    }
    
    public void greyscale() {
    	outputName = "greyscale_" + outputName;
    	for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		Color c = pixels[i][j];
        		int R = (int)(c.getRed() * 0.299);
        		int G = (int)(c.getGreen() * 0.587);
        		int B = (int)(c.getBlue() * 0.114);
        		pixels[i][j] = new Color(R + G + B, R + G + B, R + G + B);
        	}
        }
    }
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new PhotoshopFiller();
	}

    public PhotoshopFiller() {
		run();
    }
}