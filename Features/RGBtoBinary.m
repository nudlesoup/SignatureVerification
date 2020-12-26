function [image] = RGBtoBinary(image)
image = im2bw(image, 0.1);
end