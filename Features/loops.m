 image = imread('E:\this sem3\signature\image processing\signature.jpg');
image = im2bw(image, 0.5);
image = imcomplement(image);
image = imfill(image,'holes');
image1 = imread('E:\this sem3\signature\image processing\signature.jpg');
image1 = im2bw(image1, 0.5);
image1 = imcomplement(image1);
imshow(image-image1)
max(max(bwlabel(image-image1)))