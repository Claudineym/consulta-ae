import React from "react";
import PropTypes from "prop-types";
import { List, ListItem, withStyles } from "material-ui";

import footerStyle from "../../variables/styles/footerStyle";

function Footer({ ...props }) {
  const { classes } = props;
  return (
    <footer className={classes.footer}>
      <div className={classes.container}>
        <div className={classes.left}>
          <List className={classes.list}>
            <ListItem className={classes.inlineBlock}>
              <a href="#home" className={classes.block}>
                Home
              </a>
            </ListItem>            
          </List>
        </div>
        <p className={classes.right}>
          <span>
            SEF/MG - Rodovia Papa João Paulo II, nº 4001. Edifício Gerais. 7º andar. Bairro Serra Verde - Belo Horizonte-MG. CEP 31.630-901
          </span>
        </p>
      </div>
    </footer>
  );
}

export default withStyles(footerStyle)(Footer);
