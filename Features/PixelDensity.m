clc;
image = imread('C:\Users\Rishabh\Desktop\Signature Verification\example.png');
image = im2bw(image, 0.5);
[x,y] = size (image);
for i= 1:1:x
    counter_x(i) = 0;
end
for i=1:1:x
    j = 1;
    for j=1:1:y
        if(image(i,j)==0)
        counter_x(i) = counter_x(i) + 1;
        end
    end
end

for i=1:1:x
    counter_x(i)
end
Cx(1:x) = (1:x);
plot(Cx, counter_x,'--r');
for i= 1:1:y
    counter_y(i) = 0;
end
for i=1:1:y
    j = 1;
    for j=1:1:x
        if(image(j,i)==0)
        counter_y(i) = counter_y(i) + 1;
        end
    end
end

for i=1:1:y
    counter_y(i)
end
Cy(1:y) = (1:y);
figure, plot(Cy, counter_y,'--r');