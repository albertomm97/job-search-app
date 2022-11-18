import './App.css';

import Container from 'react-bootstrap/Container';

import Header from './components/Header/Header';
import Home from './pages/Home/Home';

import { FilterOfferContextProvider } from './context/FilterOfferContext';

import { Route } from 'wouter';

import CompanyLogin from './pages/Login/CompanyLogin';
import CandidateLogin from './pages/Login/CandidateLogin';
import CompanyRegister from './pages/Register/CompanyRegister';
import CandidateRegister from './pages/Register/CandidateRegister';

import CandidateCurriculum from './pages/CV/CandidateCurriculum';
import AddWorkExperience from './pages/CV/WorkExperience/AddWorkExperience';
import EditWorkExperience from './pages/CV/WorkExperience/EditWorkExperience';
import AddStudy from './pages/CV/Studies/AddStudy';
import EditStudy from './pages/CV/Studies/EditStudy';
import AddLanguage from './pages/CV/Languages/AddLanguage';
import EditLanguage from './pages/CV/Languages/EditLanguage';
import EditDescription from './pages/CV/EditDescription';

import CompanyDetail from './pages/CompanyDetails/CompanyDetail';
import OfferCandidateDetails from './pages/Offer/OfferCandidateDetail';
import OfferCompanyDetails from './pages/Offer/OfferCompanyDetail';
import AddOffer from './pages/Offers/AddOffer';
import EditOffer from './pages/Offers/EditOffer';

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
        <Route component={AddWorkExperience} path="/cv/add-work-experience" />
        <Route component={EditWorkExperience} path="/cv/edit-work-experience" />
        <Route component={AddStudy} path="/cv/add-study" />
        <Route component={EditStudy} path="/cv/edit-study" />
        <Route component={AddLanguage} path="/cv/add-language" />
        <Route component={EditLanguage} path="/cv/edit-language" />
        <Route component={EditDescription} path="/cv/edit-description" />
        <Route component={OfferCandidateDetails} path="/job-offer/:id" />
        <Route component={OfferCompanyDetails} path="/company/job-offer/:id" />
        <Route component={CompanyDetail} path="/company" />
        <Route component={AddOffer} path="/company/add-offer" />
        <Route component={EditOffer} path="/company/edit-offer" />
      </Container>
    </div>
  );
};

export default App;
