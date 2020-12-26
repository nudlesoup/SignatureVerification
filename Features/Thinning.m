function [image] = Thinning(image)
image = imcomplement (image);
%orig = im2bw (orig, 0.5);
image = bwmorph(image, 'thin', Inf);
%figure, imshow (orig);
image = imcomplement (image);
end