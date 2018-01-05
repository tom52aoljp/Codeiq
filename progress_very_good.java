import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();

			// even number: output "invalid"
			if ((num % 2) == 0) {

				System.out.println("invalid");
			// uneven number: make output data
			} else {

				// "v" output place counter
				int vplace = 0;
				// output data
				StringBuilder line = new StringBuilder();
				StringBuilder output = new StringBuilder();
				
				// loop for lines
				for (int i = 1; i <= num; i++) {

					// even number: output previous output data
					//            : slide "v" place
					if (i % 2 == 0) {

						vplace++;
					// uneven number: make output data
					} else {

						line.setLength(0);
						// loop for characters
						for (int x = 0; x < num; x++) {

							if (x == vplace || x == (num - 1 - vplace)) {								

								line.append("v");
							} else {

								line.append(".");
							}						
						}								

						// start a new output
						String crlf = System.getProperty("line.separator");
						line.append(crlf);
					}

					output.append(line);
				}

				System.out.println(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}