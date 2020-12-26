clc;
image = imread('C:\Users\Rishabh\Desktop\Signature Verification\example.png');
image = im2bw(image, 0.5);
[x,y] = size(image);

for i=1:1:y
    check_y(i) = 0;
end

for i = 1:1:y
    for j=1:1:x
        if (image(j,i)==0)
            if(image(j-1,i-1)==1 && image(j, i-1)==1 && image(j+1,i-1)==1)
                check_y(i)=1;
            else if(image(j-1,i+1)==1 && image(j, i+1)==1 && image(j+1,i+1)==1)
                    check_y(i)=1;
                end
            end
        end    
    end
end

for i=1:1:y
    check_y(i)
end
Cy(1:x) = (1:x);
plot(Cy, check_y,'--r');
for i=1:1:x
    check_x(i) = 0;
end

for i = 1:1:x
    for j=1:1:y
        if (image(i,j)==0)
            if(image(i-1,j-1)==1 && image(i-1, j)==1 && image(i-1,j+1)==1)
                check_x(i)=1;
            else if(image(i+1,j-1)==1 && image(i+1,j)==1 && image(i+1, j+1)==1)
                    check_x(i)=1;
                end
            end
        end    
    end
end

for i=1:1:x
    check_x(i)
end
Cx(1:x) = (1:x);
figure, plot(Cx, check_x,'--r');