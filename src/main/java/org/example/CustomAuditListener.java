package org.example;

import com.puppycrawl.tools.checkstyle.api.*;
import java.util.logging.Logger;

public class CustomAuditListener implements AuditListener {
	private static final Logger logger = Logger.getLogger(CustomAuditListener.class.getName());
	@Override
	public void auditStarted(AuditEvent event) {
		// Called when the audit starts
		logger.info("Audit started");
	}

	@Override
	public void auditFinished(AuditEvent event) {
		// Called when the audit finishes
		logger.info("Audit finished");
	}

	@Override
	public void fileStarted(AuditEvent event) {
		// Called when a new file is started
		logger.info("File started: " + event.getFileName());
	}

	@Override
	public void fileFinished(AuditEvent event) {
		// Called when a file is finished
		logger.info("File finished: " + event.getFileName());
	}

	@Override
	public void addError(AuditEvent event) {
		// Called when an error is encountered
		logger.info("Error: " + event.getMessage());
	}

	@Override
	public void addException(AuditEvent event, Throwable throwable) {
		// Called when an exception occurs
		logger.info("Exception: " + throwable.getMessage());
	}


}
