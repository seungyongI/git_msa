using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Random ran = new Random();

            int num1 = ran.Next(47);
            int num2 = ran.Next(47);
            int num3 = ran.Next(47);
            int num4 = ran.Next(47);
            int num5 = ran.Next(47);
            int num6 = ran.Next(47);
            
            Console.WriteLine("num1 = " + num1);
            Console.WriteLine("num2 = " + num2);
            Console.WriteLine("num3 = " + num3);
            Console.WriteLine("num4 = " + num4);
            Console.WriteLine("num5 = " + num5);
            Console.WriteLine("num6 = " + num6);

            label1.Text = num1.ToString();
            label1.AutoSize = false;
            label1.Size = new System.Drawing.Size(147, 101);

            label2.Text = num2.ToString();
            label2.AutoSize = false;
            label2.Size = new System.Drawing.Size(147, 101);

            label3.Text = num3.ToString();
            label3.AutoSize = false;
            label3.Size = new System.Drawing.Size(147, 101);

            label4.Text = num4.ToString();
            label4.AutoSize = false;
            label4.Size = new System.Drawing.Size(147, 101);

            label5.Text = num5.ToString();
            label5.AutoSize = false;
            label5.Size = new System.Drawing.Size(147, 101);

            label6.Text = num6.ToString();
            label6.AutoSize = false;
            label6.Size = new System.Drawing.Size(167, 101);
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
