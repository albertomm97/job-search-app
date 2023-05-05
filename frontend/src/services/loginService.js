import { getAllUserData } from './CV/cvService';
import { getCompanyData } from './CompanyDetails/getCompanyData';

const loginService = (credentials, type) => {
  const userData =
    type === 'user' ? getAllUserData({ id: '1' }) : getCompanyData();
  return { jwtToken: 'test', userData: userData };
};

export default loginService;
