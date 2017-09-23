fid = fopen('maxEval.txt','r');
s = fscanf(fid,'%d',50000);
fclose(fid);

plot(1:50000,s);
%%
step = 1000;
meanMatrix  = [];
finalMatrix = [];
index = 1;
for start = 1:1000
  for i = start:step:50000
      meanMatrix(index) = s(i);
      index = index + 1;
  end
  finalMatrix(start) = mean(meanMatrix);
end

plot(1:1000,finalMatrix)
title('Basic Hill Climbing n = 5');
xlabel('Average per iteration over 50 trials');
ylabel('Moves to goal');
