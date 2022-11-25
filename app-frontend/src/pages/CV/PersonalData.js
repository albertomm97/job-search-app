import React from 'react';

const PersonalData = ({ data }) => {
  return (
    <div className="cvPart">
      <img className="cvPic" src="/logo192.png" />
      <div className="candidateDetails">
        <h4>
          {data.name} {data.surname}
        </h4>
        <p>{data.birthDate}</p>
        <p>{data.email}</p>
      </div>
    </div>
  );
};

export default PersonalData;
