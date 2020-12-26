function [image] = Rotate(image)
[x,y] = size(image);
y

for j = 1:1:y
    upper = 0;
    lower = 0;
    i = 1;
    while( upper==0 && i<=x )
        if(image(i,j)==0)
            upper = i;
            break;
        end
        i = i + 1;
    end
    i=x;
    while( lower==0 && i>=1 )
        if(image(i,j)==0)
            lower = i;
            break;
        end
        i = i - 1;
    end
    if (upper==0 && lower==0)
        result = x/2;
    else
        result = (upper+lower)/2;
    end
        middlepoint(j) = result;
end

%for i=1:1:y %outputs the middle point
 %   middlepoint(i)
%end

C(1:y)=(1:y);

p = polyfit( C, middlepoint,1);
f = polyval(p,C);
hold on
%plot(C, f,'--r'); plots the line
%plot(C, middlepoint,'--r'); plots the middle point
angle = atan((f(y)-f(1))./(y-1));
angle2 = radtodeg(angle);
image = imrotate(image,angle2 );


%new thing added

[x,y] = size(image);
if(angle>0)
% top one
tan(angle)
for j=1:1:y
    for i=1:floor((y-j)*tan(angle))+1
        image(i,j)=1;
    end
end
%left side
for i=1:1:x
    for j=1:floor((x)*tan(angle))+1
        image(i,j)=1;
    end
end

%right side
for i=1:1:x
    for j=y-floor((x-i)*tan(angle)):1:y
        image(i,j)=1;
    end
end

%bottom
for j=1:1:y
    for i=x-floor((y)*tan(angle)):1:x
        image(i,j)=1;
    end
end
end

if(angle<0)
    %top
   for j=1:1:y
    for i=1:1:floor((j)*(-tan(angle)))+1
        image(i,j)=1;
    end
   end
%right
for i=1:1:x
    for j=y-floor((i)*(-tan(angle))):1:y
        image(i,j)=1;
    end
end

%bottom
for j=1:1:y
    for i=x-floor((y-j)*(-tan(angle))):1:x
        image(i,j)=1;
    end
end

%left side
for i=1:1:x
    for j=1:floor((x-i)*(-tan(angle)))+1
        image(i,j)=1;
    end
end

end%end of if(angle<0)
end%end of the rotate funciton


