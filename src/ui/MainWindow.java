package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;

import swing2swt.layout.BoxLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import domain.Main;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class MainWindow {

	protected Shell shlGlotp;
	private Text txtPlanes;
	private Text txtRunaways;
	private Text txtTanks;
	private Text txtGates;
	private Text txtTech;
	private Text txtAuth;

	private static domain.Main domainMain;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			domainMain = new domain.Main();
			
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlGlotp.open();
		shlGlotp.layout();
		while (!shlGlotp.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlGlotp = new Shell();
		shlGlotp.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				Main.exit();
			}
		});
		shlGlotp.setSize(202, 288);
		shlGlotp.setText("GLO3004-TP2");
		shlGlotp.setLayout(new FormLayout());
		
		Group grpConfigs = new Group(shlGlotp, SWT.SHADOW_ETCHED_IN);
		grpConfigs.setText("Configs");
		grpConfigs.setLayout(new GridLayout(2, false));
		FormData fd_grpConfigs = new FormData();
		fd_grpConfigs.left = new FormAttachment(0, 10);
		grpConfigs.setLayoutData(fd_grpConfigs);
		
		Group grpControls = new Group(shlGlotp, SWT.NONE);
		fd_grpConfigs.right = new FormAttachment(grpControls, 0, SWT.RIGHT);
		fd_grpConfigs.bottom = new FormAttachment(grpControls, -6);
		
		Label lblOfPlanes = new Label(grpConfigs, SWT.NONE);
		lblOfPlanes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOfPlanes.setText("# of planes:");
		
		txtPlanes = new Text(grpConfigs, SWT.BORDER | SWT.CENTER);
		txtPlanes.setText("2");
		txtPlanes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOfAuthorities = new Label(grpConfigs, SWT.NONE);
		lblOfAuthorities.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOfAuthorities.setText("# of runways:");
		
		txtRunaways = new Text(grpConfigs, SWT.BORDER | SWT.CENTER);
		txtRunaways.setText("2");
		txtRunaways.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOfFuel = new Label(grpConfigs, SWT.NONE);
		lblOfFuel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOfFuel.setText("# of fuel tanks:");
		
		txtTanks = new Text(grpConfigs, SWT.BORDER | SWT.CENTER);
		txtTanks.setText("2");
		txtTanks.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOfGates = new Label(grpConfigs, SWT.NONE);
		lblOfGates.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOfGates.setText("# of gates:");
		
		txtGates = new Text(grpConfigs, SWT.BORDER | SWT.CENTER);
		txtGates.setText("2");
		txtGates.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOfTech = new Label(grpConfigs, SWT.NONE);
		lblOfTech.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOfTech.setText("# of technicians:");
		
		txtTech = new Text(grpConfigs, SWT.BORDER | SWT.CENTER);
		txtTech.setText("2");
		txtTech.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOfAuthorities_1 = new Label(grpConfigs, SWT.NONE);
		lblOfAuthorities_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOfAuthorities_1.setText("# of authorities:");
		
		txtAuth = new Text(grpConfigs, SWT.BORDER | SWT.CENTER);
		txtAuth.setText("2");
		txtAuth.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpControls.setText("Controls");
		FormData fd_grpControls = new FormData();
		fd_grpControls.top = new FormAttachment(0, 194);
		fd_grpControls.left = new FormAttachment(0, 10);
		grpControls.setLayoutData(fd_grpControls);
		
		Button btnStart = new Button(grpControls, SWT.NONE);
		btnStart.setBounds(10, 24, 75, 25);
		btnStart.setText("Start");
		
		Button btnPause = new Button(grpControls, SWT.NONE);
		btnPause.setEnabled(false);
		btnPause.setText("Pause");
		btnPause.setBounds(91, 24, 75, 25);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				// Start the airport
				if (btnStart.getText().compareTo("Start") == 0) {
					int auth, gates, planes, runaways, tanks, tech = 0;
					try {
						
						// Cast text to integer
						auth = Integer.parseInt(txtAuth.getText());
						gates = Integer.parseInt(txtGates.getText());
						planes = Integer.parseInt(txtPlanes.getText());
						runaways = Integer.parseInt(txtRunaways.getText());
						tanks = Integer.parseInt(txtTanks.getText());
						tech = Integer.parseInt(txtTech.getText());
						
						// Start the airport
						Main.start(planes, auth, tanks, gates, tech, runaways);
						
					} catch (NumberFormatException e1) {
						System.out.println("Configs is not set properly. Must be only integers.");
					}

					// Disable all configs textfields
					txtAuth.setEnabled(false);
					txtGates.setEnabled(false);
					txtPlanes.setEnabled(false);
					txtRunaways.setEnabled(false);
					txtTanks.setEnabled(false);
					txtTech.setEnabled(false);
					
					// Change btnStart text to 'Stop' and activate pause button
					btnStart.setText("Stop");
					btnPause.setEnabled(true);
				} else { // stop the airport
					Main.stop();
					
					txtAuth.setEnabled(true);
					txtGates.setEnabled(true);
					txtPlanes.setEnabled(true);
					txtRunaways.setEnabled(true);
					txtTanks.setEnabled(true);
					txtTech.setEnabled(true);
					
					btnStart.setText("Start");
					btnPause.setEnabled(false);
				}
			}
		});
		
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (btnPause.getText().compareTo("Pause") == 0) {
					domain.Main.pause(true);
					btnPause.setText("Unpause");
				}
				else {
					domain.Main.pause(false);
					btnPause.setText("Pause");
				}
			}
		});

	}
}
