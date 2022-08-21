import './App.css';
import NavBar from './components/NavBar';
import Student from './components/Student'
import Professor from './components/Professor'
import Misdoing from './components/MisDoings';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';



function App() {
  return (
    <Router>
      <div className="App">
        <NavBar />
        <Switch>
          <Route path='/student'>
            <Student />
          </Route>
          <Route path='/professor'>
            <Professor />
          </Route>
          <Route>
            <Misdoing path='/misdoing' />
          </Route>

        </Switch>
      </div>
    </Router>
  );
}

export default App;
