import { useContext, useCallback } from 'react';

import Context from '../context/UserContext';
import loginService from '../services/loginService';

const useUser = () => {
  const { jwt, setJwt } = useContext(Context);

  const login = useCallback(
    (credentials, type) => {
      const jwt = loginService(credentials, type);
      window.sessionStorage.setItem('jwt', jwt);
      window.sessionStorage.setItem('user-type', type);
      setJwt(jwt);
    },
    [setJwt]
  );

  const logout = useCallback(() => {
    setJwt(null);
    window.sessionStorage.removeItem('jwt');
    window.sessionStorage.removeItem('user-type');
  }, [setJwt]);

  return {
    isLogged: Boolean(jwt),
    type: window.sessionStorage.getItem('user-type'),
    login,
    logout,
  };
};

export { useUser };
