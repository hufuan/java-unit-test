#include <time.h>
#include <sys/time.h>
#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

 double difftimeval(const struct timeval *start, const struct timeval *end)
 {
         double d;
         time_t s;
         long u;
         s = end->tv_sec - start->tv_sec;
         u = end->tv_usec - start->tv_usec;
         if (u < 0)
         {
            --s;
            u+= 1000000;
         }
         d = s + u/1000000.0;
         return d;
}

 int main (int argc, char *argv[])
 {
    int nsec =100*1000*1000; //100ms
    int ticks = 100;  //default 100ms * 100 = 10s
    if(argc > 2)
    {
      nsec = atoi(argv[1]);
      ticks = atoi(argv[2]);
    }
    printf("nano sec is %d,  ticks are %d\n", nsec, ticks);
    struct timeval tv1, tv2;
    gettimeofday(&tv1, NULL);
    struct timespec ts;
    ts.tv_sec = 0;
    ts.tv_nsec = nsec; //100ms
    while(ticks > 0)
    {
        nanosleep(&ts ,NULL);
        ticks--;
    }
    double res = gettimeofday(&tv2, NULL);
    res = difftimeval(&tv1, &tv2);
    printf("Accumulate sleep time: %.3lf (s)\n",  res);
 }
