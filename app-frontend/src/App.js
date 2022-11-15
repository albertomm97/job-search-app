import './App.css';

import Header from './components/Header/Header';
import Home from './pages/Home/Home';
import { FilterOfferContextProvider } from './context/FilterOfferContext';

import { Route } from 'wouter';

const App = () => {
  return (
    <div className="App">
      <Header />

      <FilterOfferContextProvider>
        <Route component={Home} path="/" />
      </FilterOfferContextProvider>
    </div>
  );
};

export default App;
