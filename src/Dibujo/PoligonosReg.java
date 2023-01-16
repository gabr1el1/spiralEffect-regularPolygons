/****************************************************************************
 *   PROGRAMA    : Programa 2.6 Poligonos Regulares
 *   AUTOR       : Gabriel Hernandez Grajeda
 *   FECHA       : 2022-03-25
 *   DESCRIPCION : Un programa que le permite al usuario dibujar un polígono regular indicando:
 *    
					1. EL número de lados
					2. La longitud del radio
					3. El ángulo inicial.
 *****************************************************************************/

package Dibujo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Conversiones.CoordenadasNormalizadas;
import Conversiones.PolaresACartesianas;


public class PoligonosReg {

	public static void main(String[] args) {
		//ACOMODANDO EL MARCO
		
		MarcoCartesianos mimarco = new MarcoCartesianos();
		
		mimarco.setTitle("Poligonos Regulares");
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
			
	}
	
	
	

}


class MarcoCartesianos extends JFrame{
	
	PanelCartesianos milaminaCart = new PanelCartesianos();
	
	public MarcoCartesianos() {
		
		
		this.setBounds(200, 200, 500, 500);
		
		this.setLayout(new BorderLayout());
		
		//Para los controles del plano cartesiano
		
		JPanel panelNorte = new JPanel();
		
		panelNorte.setLayout(new GridLayout(3,1));
		
		panelNorte.setBorder(BorderFactory.createEtchedBorder());
		
		
		
		
		
		
		
		
		//ETIQUETAS PANEL NORTE
		
		JPanel mipanelN_etiq = new JPanel();
		
		mipanelN_etiq.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		JLabel xmmin_label = new JLabel("XMmin");
		
		JLabel ymmin_label = new JLabel("YMmin");
		
		JLabel xmmax_label = new JLabel("XMmax");
		
		JLabel ymmax_label = new JLabel("YMmax");
		
		//Agregar etiquetas
		
		mipanelN_etiq.add(xmmin_label);
		
		mipanelN_etiq.add(Box.createHorizontalStrut(8));
		
		mipanelN_etiq.add(ymmin_label);
		
		mipanelN_etiq.add(Box.createHorizontalStrut(8));
		
		mipanelN_etiq.add(xmmax_label);
		
		mipanelN_etiq.add(Box.createHorizontalStrut(8));
		
		mipanelN_etiq.add(ymmax_label);
		
		
		panelNorte.add(mipanelN_etiq);
		
		
		
		//CONTROLES PANEL NORTE
		
		JPanel mipanelN_contr = new JPanel();
		
		//xmmin
		
		mipanelN_contr.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JSpinner control_xmmin = new JSpinner(new SpinnerNumberModel(-10,-1000,0,1));
		
		control_xmmin.setPreferredSize(new Dimension(50,15));
		
		control_xmmin.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.set_xmmin((int)control_xmmin.getValue());
				
				milaminaCart.repaint();
			}
			
			
		});
		
		mipanelN_contr.add(control_xmmin);
		
		
		//ymmin
		JSpinner control_ymmin = new JSpinner(new SpinnerNumberModel(-10,-1000,0,1));
		
		control_ymmin.setPreferredSize(new Dimension(50,15));
		
		control_ymmin.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.set_ymmin((int)control_ymmin.getValue());
				
				milaminaCart.repaint();
			}
			
			
		});
		
		mipanelN_contr.add(control_ymmin);
		
		
		//xmmax
		JSpinner control_xmmax = new JSpinner(new SpinnerNumberModel(10,0,1000,1));
		
		control_xmmax.setPreferredSize(new Dimension(50,15));
		
		control_xmmax.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.set_xmmax((int)control_xmmax.getValue());
				
				milaminaCart.repaint();
			}
			
			
		});
		
		mipanelN_contr.add(control_xmmax);
		
		
		//ymmax
		JSpinner control_ymmax = new JSpinner(new SpinnerNumberModel(10,0,1000,1));
		
		control_ymmax.setPreferredSize(new Dimension(50,15));
		
		control_ymmax.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.set_ymmax((int)control_ymmax.getValue());
				
				milaminaCart.repaint();
			}
			
			
		});
		
		mipanelN_contr.add(control_ymmax);
		
		
		panelNorte.add(mipanelN_contr);
		
		//CHECKBOX PANEL NORTE
		
		JPanel mipanel_check = new JPanel();
		
		mipanel_check.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		
		
		JCheckBox check1 = new JCheckBox("Draw Cartesian Axes");
		
		JCheckBox check2 = new JCheckBox("Draw Marks");
		
		JCheckBox check3 = new JCheckBox("Grid Lines");
		
		
		check1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				milaminaCart.setdrawCartesianAxes(!milaminaCart.getdrawCartesianAxes());
				
				milaminaCart.repaint();
			}
			
		});
		
		
		check2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				milaminaCart.setdrawMarks(!milaminaCart.getdrawMarks());
				
				milaminaCart.repaint();
			}
			
		});
		
		check3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				milaminaCart.setdrawGridLines(!milaminaCart.getdrawGridLines());
				
				milaminaCart.repaint();
				
			}
			
		});
		
		mipanel_check.add(check1);
		
		mipanel_check.add(check2);
		
		mipanel_check.add(check3);
		
		
		panelNorte.add(mipanel_check);
		
		
		
		//Agregar panel de etiquetas, spinners y checkbox 
		this.add(panelNorte,BorderLayout.NORTH);
		
		//PANEL QUE DIBUJA EL PLANO CARTESIANO 
		
		this.add(milaminaCart,BorderLayout.CENTER);
		
		
		//Para los controles de los poligonos
		
		JPanel panelOeste = new JPanel();
		
		panelOeste.setLayout(new GridLayout(4,1));
		
		panelOeste.setBorder(BorderFactory.createEtchedBorder());
		
		
		
		
		
		JLabel pol_reg = new JLabel("Regular polygons");
		
		JPanel mipanelO_etiqueta = new JPanel();
		
		mipanelO_etiqueta.setLayout(new FlowLayout(FlowLayout.LEFT));
		mipanelO_etiqueta.add(pol_reg);
		panelOeste.add(mipanelO_etiqueta);
		
		JPanel mipanelO_sidesComp = new JPanel();
		mipanelO_sidesComp.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lados = new JLabel("Sides");
		JSpinner control_sides = new JSpinner(new SpinnerNumberModel(3,3,360,1));
		
		
		//Permite al usuario cambiar el numero de lados del poligono
		control_sides.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.setSides((int)control_sides.getValue());
				milaminaCart.repaint();
			}
			
		});
		
		
		mipanelO_sidesComp.add(lados);
		mipanelO_sidesComp.add(control_sides);
		
		panelOeste.add(mipanelO_sidesComp);
		
		JPanel mipanelO_radioComp = new JPanel();
		mipanelO_radioComp.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel radioE = new JLabel("Radio");
		JSpinner radioS = new JSpinner(new SpinnerNumberModel(1,1,10000,0.1));
		
		radioS.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.setRadio((double)radioS.getValue());
				milaminaCart.repaint();
			}
			
		});
		
		mipanelO_radioComp.add(radioE);
		mipanelO_radioComp.add(radioS);
		
		panelOeste.add(mipanelO_radioComp);
		
		JPanel mipanelO_startAngle = new JPanel();
		mipanelO_startAngle.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel startAngle = new JLabel("Start Angle");
		JSpinner control_StAngle = new JSpinner(new SpinnerNumberModel(0,0,360,1));
		
		control_StAngle.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				milaminaCart.setStartAngle((int)control_StAngle.getValue());
				milaminaCart.repaint();
			}
			
		});
		
		
		
		
		mipanelO_startAngle.add(startAngle);
		mipanelO_startAngle.add(control_StAngle);
		
		panelOeste.add(mipanelO_startAngle);
		
		
		
		this.add(panelOeste,BorderLayout.WEST);
		milaminaCart.setBackground(Color.BLACK);
		
		
	}
	
	
	
	
}




class PanelCartesianos extends JPanel{
	
	//private static Graphics g;
	
	private  Graphics2D g2d;
	
	private CoordenadasNormalizadas cn = new CoordenadasNormalizadas();  
	
	private int xmmin=-10,ymmin=-10,xmmax=10,ymmax=10,marcaX=5,marcaY=5,sides=3,startAngle=0;
	
	private boolean drawMarks = false ,drawCartesianAxes = false, drawGridLines = false;
	
	private double radio=1;
	
	private PolaresACartesianas pol= new PolaresACartesianas(); 
	
	
	
	public void set_xmmin(int valor) {
		
		this.xmmin = valor;
		
	}
	
	public void set_ymmin(int valor) {
		
		this.ymmin=valor;
		
	}
	
	public void set_xmmax(int valor) {
		
		this.xmmax=valor;
	}
	
	public void set_ymmax(int valor) {
		
		this.ymmax=valor;
		
	}
	
	
	public void setdrawCartesianAxes(boolean estado) {
		
		this.drawCartesianAxes = estado;
		
	}
	
	
	public void setdrawMarks(boolean estado) {
		
		this.drawMarks=estado;
		
	}
	
	public void setdrawGridLines(boolean estado) {
		
		this.drawGridLines=estado;
		
	}
	
	
	public void setSides(int sides) {
		
		this.sides = sides;
	}
	
	public void setRadio(double radio) {
		
		this.radio = radio;
	}
	
	public void setStartAngle(int startAngle) {
		
		this.startAngle = startAngle;
	}
	
	
	public boolean getdrawCartesianAxes() {
		
		return this.drawCartesianAxes;
	}
	
	public boolean getdrawMarks() {
		
		return this.drawMarks;
	}
	
public boolean getdrawGridLines() {
		
		return this.drawGridLines;
	}
	
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		this.g2d=g2;
		
		this.poligono();
		
		this.coordenadas();
		

		
	}
	
	public void coordenadas() {
		
		
		
		//ANCHO Y ALTO DEL PANEL
		int maxX = g2d.getClipBounds().width-1;
		int maxY = g2d.getClipBounds().height-1;
		
		this.marcaX = maxX/75;
		this.marcaY = maxY/75;
		cn.setRangoDispositivo(0, 0, maxX, maxY); //Establecemos las medidas del dispositivo
		
		cn.setRangoMundiales(xmmin, ymmin, xmmax, ymmax); //Establecemos las medidas del plano cartesiano
		
		
		//Dibuja ejes cartesianos
		if(this.getdrawCartesianAxes()==true) {
			
			g2d.setColor(Color.WHITE);
			
			//Linea vertical plano cartesiano
			cn.setXM(0);
			cn.setYM(ymmax);
			
			int xdv1 = cn.getXD();
			int ydv1 = cn.getYD();
			
			cn.setXM(0);
			cn.setYM(ymmin);
			
			int xdv2 = cn.getXD();
			int ydv2 = cn.getYD();
			
			g2d.drawLine(xdv1, ydv1, xdv2, ydv2);
			
			//Linea horizontal plano cartesiano
			
			cn.setXM(xmmin);
			cn.setYM(0);
			
			int xdh1 = cn.getXD();
			int ydh1 = cn.getYD();
			
			cn.setXM(xmmax);
			cn.setYM(0);
			
			int xdh2 = cn.getXD();
			int ydh2 = cn.getYD();
			
			g2d.drawLine(xdh1, ydh1, xdh2, ydh2);
			
		}
		
		
		//Dibuja marcas de separación
		if(this.getdrawMarks()==true) {
			
			//Separaciones eje X
			
			g2d.setColor(Color.GRAY);
			
			cn.setYM(0);
			for(int i=xmmin;i<=xmmax;i++) {
				
				cn.setXM(i);
				
				g2d.drawLine(cn.getXD(), cn.getYD()-this.marcaX, cn.getXD(), cn.getYD()+this.marcaX);
			}
			
			
			//Separaciones eje Y
			cn.setXM(0);
			for(int i=ymmin;i<=ymmax;i++) {
				
				cn.setYM(i);
				
				g2d.drawLine(cn.getXD()-this.marcaY, cn.getYD(), cn.getXD()+this.marcaY, cn.getYD());
			}	
			
		}
		
		//Dibuja Grid
				if(this.getdrawGridLines()==true) {
					
					g2d.setColor(Color.GRAY);
					
					//Grid lineas horizontales
					
					float guiones[]= {3,3};
					g2d.setStroke(new BasicStroke(0,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,0, guiones,0));
					
					
					
					int x1,y1,x2,y2;
					
					
					cn.setXM(this.xmmin);
					x1=cn.getXD();
					
					cn.setXM(this.xmmax);
					x2=cn.getXD();
					
					for(int i=ymmin;i<=ymmax;i++) {
						
						cn.setYM(i);
						
						y1=cn.getYD();
						
						y2=cn.getYD();
						
						g2d.drawLine(x1, y1, x2, y2);
						
						
					}
					
					
					//Grid lineas verticales
					
					
					cn.setYM(this.ymmin);
					y1=cn.getYD();
					
					cn.setYM(this.ymmax);
					y2=cn.getYD();
					
					for(int i=xmmin;i<=xmmax;i++) {
						
						cn.setXM(i);
						
						x1=cn.getXD();
						
						x2=cn.getXD();
						
						g2d.drawLine(x1, y1, x2, y2);			
						
					}
					
				}

	}
	
	public void poligono() {
		
		double[][] puntos = new double[this.sides][2];
		double rad = this.radio;
		pol.setRo(rad);
		double anguloInicio=this.startAngle,anguloVar;
		
		double incrementoAng=360/this.sides;
		
		for(int z=0;z<40;z++) {
			pol.setRo(rad);
			
			for(int i=0;i<puntos.length;i++) {
				pol.setTheta(anguloInicio);
				puntos[i][0]=pol.getXCartesiano();
				puntos[i][1]=pol.getYCartesiano();
				//CONVERSION A COORDENADAS DE DISPOSITIVO
				cn.setXM(puntos[i][0]);
				cn.setYM(puntos[i][1]);
				puntos[i][0]=cn.getXD();
				puntos[i][1]=cn.getYD();
				anguloInicio+=incrementoAng;
				
			}
			g2d.setColor(Color.GREEN);
			for(int i=0;i<puntos.length;i++) {
				if(i==puntos.length-1) {
					g2d.drawLine((int)puntos[puntos.length-1][0], (int)puntos[puntos.length-1][1], (int)puntos[0][0], (int)puntos[0][1]);
				}else {
					g2d.drawLine((int)puntos[i][0], (int)puntos[i][1], (int)puntos[i+1][0], (int)puntos[i+1][1]);
				}
			}
			//Lineas que provocan el efecto///////////
			anguloInicio-=this.sides-1;
			rad-=rad/21;
			/////////////////////////////////////////
		}

	}
	
}



