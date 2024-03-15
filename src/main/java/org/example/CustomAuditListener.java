package org.example;

import com.puppycrawl.tools.checkstyle.api.*;

public class CustomAuditListener implements AuditListener {

	@Override
	public void auditStarted(AuditEvent event) {
		// Called when the audit starts
		System.out.println("Audit started");
	}

	@Override
	public void auditFinished(AuditEvent event) {
		// Called when the audit finishes
		System.out.println("Audit finished");
	}

	@Override
	public void fileStarted(AuditEvent event) {
		// Called when a new file is started
		System.out.println("File started: " + event.getFileName());
	}

	@Override
	public void fileFinished(AuditEvent event) {
		// Called when a file is finished
		System.out.println("File finished: " + event.getFileName());
	}

	@Override
	public void addError(AuditEvent event) {
		// Called when an error is encountered
		System.out.println("Error: " + event.getMessage());
	}

	@Override
	public void addException(AuditEvent event, Throwable throwable) {
		// Called when an exception occurs
		System.out.println("Exception: " + event.getMessage());
	}


}
