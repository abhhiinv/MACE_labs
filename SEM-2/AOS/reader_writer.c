#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t mutex, write_lock;
int read_count = 0;

void *reader(void *arg) {
    int id = *(int *)arg;

    sem_wait(&mutex);
    read_count++;
    if (read_count == 1)
        sem_wait(&write_lock);
    sem_post(&mutex);

    // Reading
    printf("Reader %d is reading\n", id);

    sem_wait(&mutex);
    read_count--;
    if (read_count == 0)
        sem_post(&write_lock);
    sem_post(&mutex);

    return NULL;
}

void *writer(void *arg) {
    int id = *(int *)arg;

    sem_wait(&write_lock);

    // Writing
    printf("Writer %d is writing\n", id);

    sem_post(&write_lock);

    return NULL;
}

int main() {
    pthread_t r[3], w[2];
    int rid[3] = {1, 2, 3};
    int wid[2] = {1, 2};

    sem_init(&mutex, 0, 1);
    sem_init(&write_lock, 0, 1);

    pthread_create(&r[0], NULL, reader, &rid[0]);
    pthread_create(&w[0], NULL, writer, &wid[0]);
    pthread_create(&r[1], NULL, reader, &rid[1]);
    pthread_create(&w[1], NULL, writer, &wid[1]);
    pthread_create(&r[2], NULL, reader, &rid[2]);

    for (int i = 0; i < 3; i++) pthread_join(r[i], NULL);
    for (int i = 0; i < 2; i++) pthread_join(w[i], NULL);

    sem_destroy(&mutex);
    sem_destroy(&write_lock);

    return 0;
}