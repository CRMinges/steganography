# Steganography
A Java application that used least significant bit steganography to encode a message in an image.

# About
Steganography is the practice of encoding a message in an image. With least significant bit 
steganography, the approach revolves around changing the least significant bit of each pixel's
RGB values to match a corresponding bit in the message we wish to encode. This way, the change 
is so small that the encoded image won't be noticably different to the naked eye from the original. 

# Usage
The application is best run from the command line. After downloading the files, run the `Main.java`
class. You will be prompted to either `ENCODE` a message or `DECODE` an image. From here, follow the 
directions provided to preform the operation you selected. When encoding an message, you will first 
provide the path to the directory the file will be saved in, and then the name. For decoding an image,
you provide the full path (including file name) to file you wish to decode.
