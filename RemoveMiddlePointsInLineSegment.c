/*
 ============================================================================
 Name        : RemoveMiddlePointsInLineSegment.c
 Author      : Himanshu Goel
 Version     :
 Description : This program removes the middle points from Line segments(Horizontal or vertical only) represented in  Linkedlist.
 URL for Question : http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

struct node{
	int x;
	int y;
	struct node *next;
};

struct node * insertAtEnd(struct node *start, int x, int y);
void printList( struct node * start);
struct node * removeMidPoints(struct node * start);

int main(void) {
	struct node *start = NULL;

	start = insertAtEnd(start, 0,10);
	start = insertAtEnd(start, 1,10);
	start = insertAtEnd(start, 5,10);
	start = insertAtEnd(start, 7,10);
	start = insertAtEnd(start, 7,5);
	start = insertAtEnd(start, 20,5);
	start = insertAtEnd(start, 40,5);

	printf("Original List \n");
	printList(start);

	start = removeMidPoints(start);
	printf("After Removing Mid Points\n");
	printList(start);

	return EXIT_SUCCESS;
}

struct node * insertAtEnd(struct node *start, int x, int y){
	struct node *newNode = malloc(sizeof(struct node));
	newNode->x = x;
	newNode->y = y;
	newNode->next= NULL;

	if(start==NULL){
		start=newNode;
	}else{
		struct node *tmp=start;

		while(tmp->next!=NULL){
			tmp = tmp->next;
		}

		tmp->next=newNode;
	}

	return start;
}

void printList( struct node * start){
	struct node * temp = start;

	while(temp->next!=NULL){
		printf("(%d,%d) -> ", temp->x, temp->y);
		temp = temp->next;
	}

	if(temp!=NULL){
		printf("(%d,%d)\n", temp->x, temp->y);
	}
}

struct node * removeMidPoints(struct node * start){
	struct node *lineStart, *lineEnd;
	int isHorizontal, isVertical;

	if(start!=NULL){
		lineStart = start;
		lineEnd = start;

		isHorizontal = 0;
		isVertical = 0;

		while(lineEnd->next!=NULL){
			if(isHorizontal||isVertical){
				// Check next point for same Type
				if(isVertical && (lineEnd->x==lineEnd->next->x) ){
					lineEnd = lineEnd->next;
				}else if(isHorizontal && (lineEnd->y==lineEnd->next->y)){
					lineEnd = lineEnd->next;
				}else{
					lineStart->next=lineEnd;
					lineStart=lineEnd;

					isHorizontal = 0;
					isVertical = 0;
				}
			}else{
				//set Horizontal or vertical
				if(lineEnd->x==lineEnd->next->x){
					isVertical=1;
				}else if(lineEnd->y==lineEnd->next->y){
					isHorizontal=1;
				}else{
					lineStart = lineEnd->next;
					lineEnd = lineEnd->next;
				}
			}
		}
		lineStart->next=lineEnd;
	}

	return start;
}
