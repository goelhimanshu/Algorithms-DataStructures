/*
 ============================================================================
 Name        : MaximumSumPathMergedLinkedList.c
 Author      : Himanshu Goel
 Version     :
 Description : This program merges 2 sorted list in such a way that resultant list is having maximum possible sum, where list can be changed at same values node.
 URL for Question : http://www.geeksforgeeks.org/maximum-sum-linked-list-two-sorted-linked-lists-common-nodes/

 INPUT
 -------
 List 1
	1 -> 3 -> 30 -> 90 -> 120 -> 240 -> 511
 List 2
	0 -> 3 -> 12 -> 32 -> 90 -> 125 -> 240 -> 249

 OUTPUT
 -------
 Max Sum Path List
	1 -> 3 -> 12 -> 32 -> 90 -> 125 -> 240 -> 511

 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

struct node{
	int val;
	struct node *next;
};

struct node * insertAtEnd(struct node *start, int val);
void printList( struct node * start);
struct node * maxSumPathConstruct(struct node *start1, struct node *start2);

int main(void) {
	struct node *start1 = NULL;
	struct node *start2 = NULL;

	start1 = insertAtEnd(start1, 1);
	start1 = insertAtEnd(start1, 3);
	start1 = insertAtEnd(start1, 30);
	start1 = insertAtEnd(start1, 90);
	start1 = insertAtEnd(start1, 120);
	start1 = insertAtEnd(start1, 240);
	start1 = insertAtEnd(start1, 511);

	start2 = insertAtEnd(start2, 0);
	start2 = insertAtEnd(start2, 3);
	start2 = insertAtEnd(start2, 12);
	start2 = insertAtEnd(start2, 32);
	start2 = insertAtEnd(start2, 90);
	start2 = insertAtEnd(start2, 125);
	start2 = insertAtEnd(start2, 240);
	start2 = insertAtEnd(start2, 249);

	printf("List 1 \n");
	printList(start1);

	printf("List 2 \n");
	printList(start2);


	printf("Max Sum Path List \n");
	printList(maxSumPathConstruct(start1, start2));

	return EXIT_SUCCESS;
}

struct node * insertAtEnd(struct node *start, int val){
	struct node *newNode = malloc(sizeof(struct node));
	newNode->val = val;
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
		printf("%d -> ", temp->val);
		temp = temp->next;
	}

	if(temp!=NULL){
		printf("%d\n", temp->val);
	}
}


struct node * maxSumPathConstruct(struct node *start1, struct node *start2){
	struct node *sumPathStart = NULL;

	if(start1==NULL){
		sumPathStart = start2;
	}else if(start2==NULL){
		sumPathStart = start1;
	}else{
		int sum1, sum2;
		struct node * list1, * list1Intersect, * list2, * list2Intersect;
		struct node * sumPathEnd = NULL;
		//Initialize all temp variables
		sum1=0;
		sum2=0;
		list1 = list1Intersect = start1;
		list2 = list2Intersect = start2;

		while(list1Intersect->next!=NULL || list2Intersect->next!=NULL){
			if(list1Intersect->val > list2Intersect->val){
				sum2 += list2Intersect->val;
				list2Intersect = list2Intersect->next;
			}else if(list1Intersect->val < list2Intersect->val){
				sum1 += list1Intersect->val;
				list1Intersect = list1Intersect->next;
			}else{
				if(sum1>sum2){
					if(sumPathStart==NULL){
						sumPathStart=list1;
					}else{
						sumPathEnd->next = list1;
					}
					sumPathEnd = list1Intersect;
				}else{
					if(sumPathStart==NULL){
						sumPathStart=list2;
					}else{
						sumPathEnd->next = list2;
					}
					sumPathEnd = list2Intersect;
				}

				if(list1Intersect->next!=NULL){
					list1 = list1Intersect = list1Intersect->next;
				}

				if(list2Intersect->next!=NULL){
					list2 = list2Intersect = list2Intersect->next;
				}

				sum1 = 0;
				sum2 = 0;

			}
		}

		if(list1Intersect!=NULL){
			sum1+=list1Intersect->val;
		}

		if(list2Intersect!=NULL){
			sum2+=list2Intersect->val;
		}

		if(sum1+sum2>0){
			if(sum1>sum2){
				if(sumPathStart==NULL){
					sumPathStart=list1;
				}else{
					sumPathEnd->next = list1;
				}
			}else{
				if(sumPathStart==NULL){
					sumPathStart=list2;
				}else{
					sumPathEnd->next = list2;
				}
			}
		}

	}

	return sumPathStart;
}
