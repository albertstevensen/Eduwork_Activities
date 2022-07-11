/// <reference types ="cypress" />

describe('automated zero web', () =>{
    it('Zero web simulation custom commands', () => {
        cy.visit('http://zero.webappsecurity.com/login.html')
        cy.url().should('include', 'login.html')
        cy.fixture("zeroWeb").then(zeroWeb =>{
            const username = zeroWeb.username
            const password = zeroWeb.password

            cy.login('username', 'password')
        })

        cy.get('#pay_bills_tab').click()
        cy.get('h2').should('have.text', 'Make payments to your saved payees')

        cy.payBill()

        cy.get('#alert_content').should('contain.text', 'The payment was successfully submitted.')
    });
});