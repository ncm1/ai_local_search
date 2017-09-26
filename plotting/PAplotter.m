fid = fopen('maxEvalPA.txt','r');
s = fscanf(fid,'%d ',500);
fclose(fid);

plot(1:500,s);
%%
step = 10;
meanMatrix  = [];
finalMatrix = [];
index = 1;
for start = 1:50
  for i = start:step:500
      meanMatrix(index) = s(i);
      index = index + 1;
  end
  finalMatrix(start) = mean(meanMatrix);
end


meanTime = [];
finalTime = [];
for start = 1:50
  for i = start:step:500
      meanTime(index) = s(i);
      index = index + 1;
  end
  finalTime(start) = mean(meanTime);
end

plot(finalTime,finalMatrix)
title('Population Approach n = 11');
xlabel('Evaluation time over 50 trials');
ylabel('Moves to goal');
