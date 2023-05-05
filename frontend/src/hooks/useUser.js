import { useContext, useCallback } from 'react';

import Context from '../context/UserContext';
import loginService from '../services/loginService';

const useUser = () => {
  const { jwt, setJwt } = useContext(Context);

  const login = useCallback(
    (credentials, type) => {
      const { jwtToken, userData } = loginService(credentials, type);
      window.sessionStorage.setItem('jwt', jwtToken);
      window.sessionStorage.setItem('user-type', type);
      window.sessionStorage.setItem('current-user', JSON.stringify(userData));
      setJwt(jwtToken);
    },
    [setJwt]
  );

  const logout = useCallback(() => {
    setJwt(null);
    window.sessionStorage.removeItem('jwt');
    window.sessionStorage.removeItem('user-type');
    window.sessionStorage.removeItem('current-user');
  }, [setJwt]);

  return {
    isLogged: Boolean(jwt),
    type: window.sessionStorage.getItem('user-type'),
    userData: JSON.parse(window.sessionStorage.getItem('current-user')),
    login,
    logout,
  };
};

export { useUser };
