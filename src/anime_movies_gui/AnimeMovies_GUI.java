package anime_movies_gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class AnimeMovies_GUI extends javax.swing.JFrame
{

    // private data fields
    private String sql;
    private Movie_Read movie_read;
    private Movie_Write movie_write;
    private Object [][] dataSet;
    private DefaultTableModel moviesTableModel;
    int movieID;

    public AnimeMovies_GUI()
    {
        // customised column names for movie JTable
        String [] columnNames_Movies = new String[] {"ID", "Title", "Year", "Director", "Length (mins)", "Rating"};

        // default row for movie JTable
        Object[] defaultData_Movies = {"0", "NA", "NA", "NA", "NA", "NA"};

        // set up customisation for movie JTable
        moviesTableModel = new DefaultTableModel();
        moviesTableModel.setColumnIdentifiers(columnNames_Movies);
        moviesTableModel.addRow(defaultData_Movies);
        initComponents(); // already provided in your generated code

        // initialise private data fields
        sql = "";
        movie_read = null;
        movie_write = null;
        dataSet = null;
        movieID = 0;

        // customise column sizing for movie_JTable
        resizeMovieTableColumns();

        // get movie data and set up in table
        getMovieData();
    }

    // resize columns in movie_JTable
    private void resizeMovieTableColumns()
    {
        // "ID", "Title", "Year", "Director", "Length", "Rating"
        // (total numeric values must = 1)
        double[] columnWidthPercentage = {0.05f, 0.3f, 0.1, 0.3f, 0.15f, 0.1f};
        int tableWidth = movies_JTable.getWidth();
        TableColumn column;
        TableColumnModel tableColumnModel =
        movies_JTable.getColumnModel();

        int cantCols = tableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++)
        {
            column = tableColumnModel.getColumn(i);
            float pWidth = Math.round(columnWidthPercentage[i] *
            tableWidth);
            column.setPreferredWidth((int)pWidth);
        }
    } // end resizeMovieTableColumns() method

    public void getMovieData()
    {
        sql = "SELECT movieID, title, releaseYear, director, length, rating FROM animeDB.animeMovies;";
        movie_read = new Movie_Read(sql, "select_movies");
        System.out.println(movie_read.getErrorMessage());
        if (movie_read.getRecordCount() > 0)
        {
            // first, remove all existing rows
            if (moviesTableModel.getRowCount() > 0)
            {
                for (int i = moviesTableModel.getRowCount() - 1; i > -1; i--)
                {
                    moviesTableModel.removeRow(i);
                }
            }
            // next, put new set of row data
            if (movie_read.getObjDataSet() != null)
            {
                // add data to tableModel
                for (int row = 0; row <
                movie_read.getObjDataSet().length; row++)
                {
                    moviesTableModel.addRow(movie_read.getObjDataSet()[row]);
                }

                // update
                moviesTableModel.fireTableDataChanged();
            }
        }
        else
        {
            // no records found
        }

        // check if any errors
        if (movie_read.getErrorMessage().length() > 0)
        {
            System.out.println(movie_read.getErrorMessage());
        }
    } // end getMovieData() method

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movies_JTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        title_JTextField = new javax.swing.JTextField();
        director_JTextField = new javax.swing.JTextField();
        length_JTextField = new javax.swing.JTextField();
        year_JTextField = new javax.swing.JTextField();
        rating_JComboBox = new javax.swing.JComboBox<>();
        clear_JButton = new javax.swing.JButton();
        insert_JButton = new javax.swing.JButton();
        update_JButton = new javax.swing.JButton();
        delete_JButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anime Movies");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Anime Movie Database");

        movies_JTable.setModel(moviesTableModel);
        movies_JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movies_JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(movies_JTable);

        jLabel2.setText("Film Title:");

        jLabel3.setText("Director:");

        jLabel4.setText("Rating:");

        jLabel5.setText("Year of release:");

        jLabel6.setText("Length (mins)");

        rating_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G", "PG", "PG 13+", "M", "MA 15+", "R 18+", "X 18+", "NR" }));

        clear_JButton.setText("CLEAR");
        clear_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_JButtonActionPerformed(evt);
            }
        });

        insert_JButton.setText("INSERT");
        insert_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_JButtonActionPerformed(evt);
            }
        });

        update_JButton.setText("UPDATE");
        update_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_JButtonActionPerformed(evt);
            }
        });

        delete_JButton.setText("DELETE");
        delete_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_JButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(title_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(director_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(year_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(length_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rating_JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(insert_JButton)
                                .addComponent(clear_JButton))
                            .addComponent(update_JButton)
                            .addComponent(delete_JButton, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(title_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(director_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(year_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(length_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(rating_JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(176, 176, 176))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clear_JButton)
                        .addGap(18, 18, 18)
                        .addComponent(insert_JButton)
                        .addGap(18, 18, 18)
                        .addComponent(update_JButton)
                        .addGap(18, 18, 18)
                        .addComponent(delete_JButton)
                        .addGap(212, 212, 212))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_JButtonActionPerformed
        // clear all text fields
        movieID = 0;
        title_JTextField.setText("");
        year_JTextField.setText("");
        director_JTextField.setText("");
        length_JTextField.setText("");
        rating_JComboBox.setSelectedItem("NR");
    }//GEN-LAST:event_clear_JButtonActionPerformed

    private void update_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_JButtonActionPerformed
        // UPDATE AN EXISTING RECORD
        if (movieID > 0 && validateData() == true)
        {
            String titleStr = title_JTextField.getText();
            int releaseYear = Integer.parseInt(year_JTextField.getText());
            String directorStr = director_JTextField.getText();
            int length = Integer.parseInt(length_JTextField.getText());
            
            String ratingStr = rating_JComboBox.getSelectedItem().toString();
            
            String sql = "UPDATE animeMovies SET title = '" + titleStr + "', ";
            sql += "releaseYear = " + releaseYear + ", ";
            sql += "director = '" + directorStr + "', ";
            sql += "length = " + length + ", ";
            sql += "rating = '" + ratingStr + "' ";
            sql += "WHERE movieID = " + movieID + ";";
            
            System.out.println(sql);
            int yesOrNo = javax.swing.JOptionPane.showConfirmDialog(null, "You are about to update movie " + movieID + " - " + titleStr + " (" + releaseYear + ")\nDo you wish to continue?", "Movie Update", javax.swing.JOptionPane.YES_NO_OPTION);
            if (yesOrNo == javax.swing.JOptionPane.NO_OPTION)
            {
                System.out.println("Update cancelled");
            } 

            else
            {
                System.out.println("Update proceeding");

                // proceed with update
                movie_write = new Movie_Write(sql);
                if (movie_write.getErrorMessage().length() > 0)
                {
                    System.out.println(movie_write.getErrorMessage());
                }

                else
                {
                    getMovieData();
                }
            }
        }
        
        else
        {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR: Must select a movie to update first!", "ERROR found!",
            javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    }    

    public boolean validateData()
    {
        boolean status = false;
        if (title_JTextField.getText().length() > 0)
        {
           if (year_JTextField.getText().matches("[0-9]+"))
            //if (year_JTextField.getText().length() > 0)
            {
                if (director_JTextField.getText().length() > 0)
                {
                    if (length_JTextField.getText().length() > 0)
                    {
                        if (length_JTextField.getText().matches("[0-9]+"))
                        {
                            status = true;
                        }
                    }
                }
            }
        }
        
        return status;
    }//GEN-LAST:event_update_JButtonActionPerformed

    private void movies_JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movies_JTableMouseClicked
        // handling code:
        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());

        // int column = source.columnAtPoint(evt.getPoint());
        movieID = Integer.parseInt(source.getModel().getValueAt(row, 0) + "");
        System.out.println("MovieID to display: " + movieID);
        String title = source.getModel().getValueAt(row, 1) + "";
        title_JTextField.setText(title);
        String year = source.getModel().getValueAt(row, 2) + "";
        year_JTextField.setText(year);
        String director = source.getModel().getValueAt(row, 3) + "";
        director_JTextField.setText(director);
        String length = source.getModel().getValueAt(row, 4) + "";
        length_JTextField.setText(length);
        String rating = source.getModel().getValueAt(row, 5) + "";
        rating_JComboBox.setSelectedItem(rating);
    }//GEN-LAST:event_movies_JTableMouseClicked

    private void delete_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_JButtonActionPerformed
        // DELETE AN EXISTING RECORD
        if (movieID > 0 && validateData() == true)
        {
            String titleStr = title_JTextField.getText();
            int releaseYear = Integer.parseInt(year_JTextField.getText());
            String sql = "DELETE FROM animeMovies WHERE movieID = " + movieID + ";";
            System.out.println(sql);
            int yesOrNo = javax.swing.JOptionPane.showConfirmDialog(null, "You are about to delete movie " + movieID + " - " + titleStr + " (" + releaseYear + ")\nDo you wish to continue?",
            "Movie Delete", javax.swing.JOptionPane.YES_NO_OPTION);
            
            if (yesOrNo == javax.swing.JOptionPane.NO_OPTION)
            {
                System.out.println("Delete cancelled");
            }

            else
            {
                System.out.println("Delete proceeding");

                // proceed with delete
                movie_write = new Movie_Write(sql);

                if (movie_write.getErrorMessage().length() > 0)
                {
                    System.out.println(movie_write.getErrorMessage());
                }

                else
                {
                    getMovieData();
                }
            }
        }

        else
        {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR: Must select a movie to delete first!", "ERROR found!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_JButtonActionPerformed

    private void insert_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_JButtonActionPerformed
        // INSERT A NEW RECORD
        if (movieID == 0)
        {
            if (validateData() == true)
            {
                String titleStr = title_JTextField.getText();
                int releaseYear = Integer.parseInt(year_JTextField.getText());
                String directorStr = director_JTextField.getText();
                int length = Integer.parseInt(length_JTextField.getText());
                String ratingStr = rating_JComboBox.getSelectedItem().toString();
                String sql = "INSERT INTO animeMovies (title, releaseYear, director, length, rating) VALUES (" + "'" + titleStr + "', " + releaseYear + ", " + "'" + directorStr + "', "  + length + ", " + "'" + ratingStr + "');";
                System.out.println(sql);

                int yesOrNo = javax.swing.JOptionPane.showConfirmDialog(null,
                "You are about to insert a new movie record: " + titleStr + " (" + releaseYear + ")\nDo you wish to continue?", "Movie Update", javax.swing.JOptionPane.YES_NO_OPTION);
                if (yesOrNo == javax.swing.JOptionPane.NO_OPTION)
                {
                    System.out.println("Insert cancelled");
                }

                else
                {
                    System.out.println("Insert proceeding");

                    // proceed with insert
                    movie_write = new Movie_Write(sql);
                    if (movie_write.getErrorMessage().length() > 0)
                    {
                        System.out.println(movie_write.getErrorMessage());
                    }

                    else
                    {
                        getMovieData();
                    }
                }
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(null, "ERROR: Must enter all fields to create a new record!", "ERROR found!", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }

        else
        {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR: Record already exists! Did you clear and enter a new record?", "ERROR found!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_insert_JButtonActionPerformed
        public static void main(String args[]) 
        {
            java.awt.EventQueue.invokeLater(new Runnable() 
            {
                public void run() 
                {
                    new AnimeMovies_GUI().setVisible(true);
                }
            });
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_JButton;
    private javax.swing.JButton delete_JButton;
    private javax.swing.JTextField director_JTextField;
    private javax.swing.JButton insert_JButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField length_JTextField;
    private javax.swing.JTable movies_JTable;
    private javax.swing.JComboBox<String> rating_JComboBox;
    private javax.swing.JTextField title_JTextField;
    private javax.swing.JButton update_JButton;
    private javax.swing.JTextField year_JTextField;
    // End of variables declaration//GEN-END:variables
}
