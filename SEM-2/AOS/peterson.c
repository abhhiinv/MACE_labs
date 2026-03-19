#include <stdio.h>
#include <pthread.h>

#define true 1
#define false 0

int flag[2] = {false, false};
int turn;

void *process(void *arg) {
    int id = *(int *)arg;
    int other = 1 - id;

    // Entry section
    flag[id] = true;
    turn = other;
    while (flag[other] == true && turn == other);

    // Critical section
    printf("Process %d entering critical section\n", id);
    printf("Process %d leaving critical section\n", id);

    // Exit section
    flag[id] = false;

    return NULL;
}

int main() {
    pthread_t t1, t2;
    int id1 = 0, id2 = 1;

    pthread_create(&t1, NULL, process, &id1);
    pthread_create(&t2, NULL, process, &id2);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}