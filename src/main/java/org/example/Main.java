package org.example;



import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.*;
import java.util.List;




public class Main {
	public static void main(String[] args) {



		final String username = "fathimanabeela";
		final String repositoryName = "oauth2appinspringboot";
		final String filePath = "src/main/java/com/example/oauth2/controller/HomeController.java";

		try {
			// Create GitHub instance using GitHubBuilder
			GitHub github = new GitHubBuilder().build();

			// Get the repository
			GHRepository repository = github.getRepository(username + "/" + repositoryName);

			// Get the content of the file
			GHContent content = repository.getFileContent(filePath);

			String fileContents = content.getContent();

			// Write file contents to a temporary file
			File tempFile = createTempFile(fileContents);



			Checker checker = new Checker();
			checker.setModuleClassLoader(Checker.class.getClassLoader());
			checker.configure(createDefaultConfiguration());

			List<File> fileList = List.of(tempFile);


			// Create an instance of your custom AuditListener
			AuditListener listener = new CustomAuditListener();

			// Add the AuditListener to the Checker
			checker.addListener(listener);

			// Process the file contents
			checker.process(fileList);


			// Clean up temporary file
			tempFile.delete();

		} catch (IOException | CheckstyleException e) {
			e.printStackTrace();
		}

	}

	private static DefaultConfiguration createDefaultConfiguration() {
		// Use the default Checkstyle configuration
		DefaultConfiguration defaultConfig = new DefaultConfiguration("Checker");
		defaultConfig.addAttribute("charset", "UTF-8");
		return defaultConfig;
	}
	private static File createTempFile(String content) throws IOException {
		File tempFile = File.createTempFile("tempJavaFile", ".java");


		try (FileWriter writer = new FileWriter(tempFile)) {
			writer.write(content);
		}

		return tempFile;
	}
}

