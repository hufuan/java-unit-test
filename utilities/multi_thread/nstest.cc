#include <time.h>
#include <sys/time.h>
#include <pthread.h>
 #include <stdio.h>
 #define NUM_THREADS     5
 int stats[NUM_THREADS] = {0};
 void *nnsleep(void *threadid)
 {
    struct timespec ts;
    ts.tv_sec = 0;
    ts.tv_nsec = 1;
    long tid;
    tid = (long)threadid;
    while(1){
    nanosleep(&ts ,NULL);
    stats[tid] += 1;
    if(stats[tid] > 10000000)
    {
      printf("stats is 10000000 for tid:%ld \n", tid);
      stats[tid] = 0;
    }
    }
    printf("Hello World! It's me, thread #%ld!\n", tid);
    pthread_exit(NULL);
 }

 int main (int argc, char *argv[])
 {
    pthread_t threads[NUM_THREADS];
    int rc;
    long t;
    for(t=0; t<NUM_THREADS; t++){
       printf("In main: creating thread %ld\n", t);
       rc = pthread_create(&threads[t], NULL, nnsleep, (void *)t);
       if (rc){
          printf("ERROR; return code from pthread_create() is %d\n", rc);
       }
    }

    /* Last thing that main() should do */
    for(t=0;t<NUM_THREADS;t++)
    {
        pthread_join(t, NULL);
    }
 }