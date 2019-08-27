import React from 'react';

class Footer extends React.Component {
  render() {
    return (
      <footer className="footer" id="footer">
        <div className="copyright">
          <a href="#">Spring MVC</a> &amp; <a href="#">ReactJS</a>  | <span className="js-now-year">2016</span>
        </div>
      </footer>
    );
  }
}

export default Footer;