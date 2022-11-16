import './App.css';

import Container from 'react-bootstrap/Container';

import Header from './components/Header/Header';
import Home from './pages/Home/Home';

import CompanyLogin from './pages/Login/CompanyLogin';
import CandidateLogin from './pages/Login/CandidateLogin';
import CompanyRegister from './pages/Register/CompanyRegister';
import CandidateRegister from './pages/Register/CandidateRegister';
import CandidateCurriculum from './pages/CV/CandidateCurriculum';

import { FilterOfferContextProvider } from './context/FilterOfferContext';

import { Route } from 'wouter';

const App = () => {
  return (
    <div className="App">
      <Header />
      <Container className="mainContent">
        <FilterOfferContextProvider>
          <Route component={Home} path="/" />
        </FilterOfferContextProvider>

        <Route component={CompanyLogin} path="/company-login" />
        <Route component={CandidateLogin} path="/candidate-login" />
        <Route component={CompanyRegister} path="/company-register" />
        <Route component={CandidateRegister} path="/candidate-register" />
        <Route component={CandidateCurriculum} path="/cv" />
      </Container>
    </div>
  );
};

export default App;
