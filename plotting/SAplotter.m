fid = fopen('maxEvalSA.txt','r');
s = fscanf(fid,'%d ',2500000);
fclose(fid);

plot(1:2500000,s);
%%
step = 50000;
meanMatrix  = [];
finalMatrix = [];
index = 1;
for start = 1:50000
  for i = start:step:2500000
      meanMatrix(index) = s(i);
      index = index + 1;
  end
  finalMatrix(start) = mean(meanMatrix);
end

plot(1:50000,finalMatrix)
title('SA n = 11');
xlabel('Average per iteration over 50 trials');
ylabel('Moves to goal');
