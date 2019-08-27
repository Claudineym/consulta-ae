import React from "react";
import ReactDOM from 'react-dom';
import MUIDataTable from "mui-datatables";
import { createMuiTheme, MuiThemeProvider } from 'material-ui/styles';

class Sistema extends React.Component {

          getMuiTheme = () => createMuiTheme({
              overrides: {
                MUIDataTableHead: {
                  main: {
                    background: "linear-gradient(2deg, #ff4f30, #930000)"
                  }
                },
              MuiTableCell:{
                head:{
                  color: "#ffffff",
                  fontWeight: "bold",
                  fontSize: "1.3em",
                }
              }
              }
            })

  render(){
    const columns = ["Sistema","Arquivo"];

    const data = [
      ["SPIDE", "install_SPIDE.xml"],
      ["AEMG", "install_AEMG.xml"],
      ["AEBR", "install_AEBR.xml"],
    ];


        const options = {
              filter: true,
              selectableRows: true,
              filterType: 'multiselect',
              responsive: 'stacked',
              onRowsSelect: (rowsSelected, allRows) => {
                console.log(rowsSelected);
              },
              onRowsDelete: (rowsDeleted) => {
                console.log(rowsDeleted, "were deleted!");
              },
              onChangePage: (numberRows) => {
                console.log(numberRows);
              },
              onSearchChange: (searchText) => {
                console.log(searchText);
              }
            };

    return(
      <MuiThemeProvider theme={this.getMuiTheme()}>
      <MUIDataTable
          title={"Sistemas"}
          data={data}
          columns={columns}
          options={options}
          pagination={true}
        />
      </MuiThemeProvider>
    );
  }
}

export default Sistema;
