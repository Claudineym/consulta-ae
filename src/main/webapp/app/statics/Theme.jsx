import { createMuiTheme } from 'material-ui/styles';

const theme = createMuiTheme({
    overrides: {
        MuiButton: {
          // Name of the styleSheet
          root: {
            // Name of the rule
            background: '#D8777B',
            borderRadius: 3,
            border: 0,
            color: 'white',
            height: 48,
            padding: '0 30px',
            boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .30)',
          },
        },
      },
  });


export default theme;