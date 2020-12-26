%asdf
clc;
clear all;
image = imread('E:\this sem3\signature\image processing\images.jpg');
c = size(image);
c(1)

% considering 
count = 1;
flag =0;
d=floor(c(1,2)/4);
for i= 1:c(1,1)/2
    if image(i, d+1 )==0
        ans(count) = i;
        count=count+1;
        flag = 1;
        break;
    end
end
if flag==0
    ans(count) = -1;
    count = count +1;
end
flag =0;
for i= 1:c(1,1)./2
    if image(i, floor(c(1,2)./2) )==0
        ans(count) = i;
        count=count+1;
         flag = 1;
        break;
    end
   
end
if flag==0
    ans(count) = -1;
    count = count +1;
end
flag =0;
for i= 1:floor((c(1,1))./2)
    if image(i, floor(3.*c(1,2)./8))==0
        ans(count) = i;
        count=count+1;
         flag = 1;
        break;
    end
  
end
if flag==0
    ans(count) = -1;
    count = count +1;
end
flag =0;
for i= c(1,1) : c(1:1)/4
    if image(i, floor(c(1,2)./4) )==0
        ans(count) = i;
        count=count+1;
         flag = 1;
        break;
    end
   
end
if flag==0
    ans(count) = -1;
    count = count +1;
end
flag =0;
for i= c(1,1)-1 :-1: 1
    if image(i, floor(c(1,2)/2) )==0
        ans(count) = i;
        count=count+1;
         flag = 1;
        break;
    end
     
end
if flag==0
    ans(count) = -1;
    count = count +1;
end
flag =0;
for i= c(1,1):-1:1
    if image(i, floor(3.*c(1,2)./4) )==0
        ans(count) = i;
        count=count+1;
         flag = 1;
        break;
    end

end
if flag==0
    ans(count) = -1;
    count = count +1;
end
count