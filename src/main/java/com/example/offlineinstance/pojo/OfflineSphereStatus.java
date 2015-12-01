package com.example.offlineinstance.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OfflineSphereStatus {

	private List<WaitingQueueItem>		waitingQueue	= new ArrayList<>();
	private List<ProcessedQueueItem>	processedQueue	= new ArrayList<>();
	private WaitingQueueItem processingItem;
	
	public void addWaitingItem(WaitingQueueItem item) {
		waitingQueue.add(item);
	}
	
	public void addProcessedItem(ProcessedQueueItem item) {
		processedQueue.add(item);
	}
	
}
