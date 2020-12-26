clc;
clear all;
image = imread('E:\this sem3\signature\image processing\signature.jpg');
figure, imshow(image);

%convert to black and white from RGB
image = RGBtoBinary(image);

%remove noise
%%image = NoiseRemoval (image);
%show the image after removing noise
%figure, imshow(image);

%thinning
%%image = Thinning(image);
%show the thinned image
%figure, imshow(image);

%rotate
image = Rotate(image);
%show the rotated image
figure, imshow(image);

