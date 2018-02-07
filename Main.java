package steganography;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

/**
 * @author mingescharlie
 *
 */
public class Main {

	public static void main (String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Welcome to steganography app \n" +
				"Please choose an option to either encode or decode an image: \n" +
				"To encode, type and enter ENCODE \n" +
				"To decode, type and enter DECODE \n");

		String option = input.nextLine().toUpperCase();

		

		if (option.equals("ENCODE")) {
			System.out.println("Please provide path to file, including file name, starting at home directory:");

			String filename = input.nextLine();
			File inFile = new File(filename);

			BufferedImage initImage = null;
			try {
				initImage = ImageIO.read(inFile);
			} catch ( IOException e ) {
				System.out.println("File not found; " + e.getMessage());
			}
			
			System.out.println("Please enter the name of the file you wish to save image as:");
			String fileName = input.nextLine();
			System.out.println("Please enter the message you wish to encode:");
			String message = input.nextLine();

			String bitMsg = Encode.encodeMessage(message);
			BufferedImage newImage = Encode.encodeImage(bitMsg,initImage);

			File finalImage;

			try {
				finalImage = new File("/Users/mingescharlie/Pictures/steganography/" + fileName);
				ImageIO.write(newImage,"png",finalImage);
				System.out.println("New image saved!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} 

		} else if (option.equals("DECODE")) {
			System.out.println("Please enter the full path of the image file you wish to decode:");
			String filePath = input.nextLine();

			File outFile = new File(filePath);
			BufferedImage image = null;
			try {
				image = ImageIO.read(outFile);
			} catch ( IOException e ) {
				System.out.println("File not found: " + e.getMessage());
				e.printStackTrace();
			}	

			String bitMessage = Decode.decodeMessage(image);
			String subBM = bitMessage.substring(bitMessage.length()-16,bitMessage.length());
			System.out.println(Decode.getMessage(bitMessage));
		} else {
			System.out.println("Command unknown, please try again");
		}


	}
}
