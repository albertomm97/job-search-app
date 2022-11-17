import React, { useEffect, useState } from 'react';
import { getPersonalData } from '../../services/CV/getPersonalData';

const PersonalData = () => {
  const [personalData, setData] = useState({});

  useEffect(() => {
    setData(getPersonalData());
  }, []);

  return (
    <div className="cvPart">
      <img className="cvPic" src="/logo192.png" />
      <div className="candidateDetails">
        <h4>
          {personalData.name} {personalData.surname}
        </h4>
        <p>{personalData.birthDate}</p>
        <p>{personalData.email}</p>
      </div>
    </div>
  );
};

export default PersonalData;
